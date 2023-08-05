package ru.otus.numberswriter;

import java.util.*;

public class NumbersWriter {
    private static final Map<Long, String> TENS = Map.of(
            20L, "двадцать",
            30L, "тридцать",
            40L, "сорок",
            50L, "пятьдесят",
            60L, "шестьдесят",
            70L, "семьдесят",
            80L, "восемьдесят",
            90L, "девяносто"
    );
    private static final Map<Long, String> HUNDREDS = Map.of(
            100L, "сто",
            200L, "двести",
            300L, "триста",
            400L, "четыреста",
            500L, "пятьсот",
            600L, "шестьсот",
            700L, "семьсот",
            800L, "восемьсот",
            900L, "девятьсот"
    );
    private static final Map<Long, String> BELOW_TWENTY = Map.ofEntries(
            Map.entry(0L, "ноль"),
            Map.entry(1L, "один"),
            Map.entry(2L, "два"),
            Map.entry(3L, "три"),
            Map.entry(4L, "четыре"),
            Map.entry(5L, "пять"),
            Map.entry(6L, "шесть"),
            Map.entry(7L, "семь"),
            Map.entry(8L, "восемь"),
            Map.entry(9L, "девять"),
            Map.entry(10L, "десять"),
            Map.entry(11L, "одиннадцать"),
            Map.entry(12L, "двенадцать"),
            Map.entry(13L, "тринадцать"),
            Map.entry(14L, "четырнадцать"),
            Map.entry(15L, "пятнадцать"),
            Map.entry(16L, "шестнадцать"),
            Map.entry(17L, "семнадцать"),
            Map.entry(18L, "восемнадцать"),
            Map.entry(19L, "девятнадцать"),
            Map.entry(1001L, "одна"),
            Map.entry(1002L, "две")
    );
    private final Morfer morfer;
    private final Currency currency;

    public NumbersWriter(Morfer morfer, Currency currency) {
        this.morfer = morfer;
        this.currency = currency;
    }

    public String getNumberInWords(Long number) {
        var partsOfNumber = new ArrayList<String>();
        partsOfNumber.add(morfer.morf(number, currency.getForms()));
        var ranges = Range.values();
        var i = 0;
        do {
            var temp = number % 1000;
            if (temp > 0 || i == 0) {
                var forms = ranges[i].getForms();
                if (!forms.isEmpty()) {
                    partsOfNumber.add(morfer.morf(temp, ranges[i].getForms()));
                }
                partsOfNumber.add(getNumbersRangeInWords(temp, ranges[i].getGender()));
            }
            i++;
            number /= 1000;
        } while (number > 0);
        Collections.reverse(partsOfNumber);
        return String.join(" ", partsOfNumber);
    }

    private String getNumbersRangeInWords(Long number, Character gender) {
        var stringJoiner = new StringJoiner(" ");
        var hundreds = number - number % 100;
        var tens = number - hundreds - number % 10;
        var units = tens < 20 ? number - hundreds : number % 10;

        if (HUNDREDS.get(hundreds) != null) {
            stringJoiner.add(HUNDREDS.get(hundreds));
        }
        if (TENS.get(tens) != null) {
            stringJoiner.add(TENS.get(tens));
        }
        if (!(units == 0 && (hundreds | tens) != 0 )) {
                stringJoiner.add(BELOW_TWENTY.get(
                        units + 1000 * (gender == 'F' && (units == 1 || units == 2) ? 1 : 0)
                ));
        }
        return stringJoiner.toString();
    }

    private enum Range {
        UNITS('M'),
        THOUSANDS('F'),
        MILLIONS('M'),
        BILLIONS('M');

        private final Character gender;
        private static final Map<Range, List<String>> FORMS = Map.of(
                Range.valueOf("THOUSANDS"), List.of("тысяча", "тысячи", "тысяч"),
                Range.valueOf("MILLIONS"), List.of("миллион", "миллиона", "миллионов"),
                Range.valueOf("BILLIONS"), List.of("миллиард","миллиарда","миллиардов")
        );

        Range(Character gender) {
            this.gender = gender;
        }

        public Character getGender() {
            return gender;
        }

        public List<String> getForms() {
            return FORMS.getOrDefault(this, Collections.emptyList());
        }
    }
}
