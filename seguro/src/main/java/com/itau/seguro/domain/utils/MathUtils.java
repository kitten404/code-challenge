package com.itau.seguro.domain.utils;

import static java.lang.Double.parseDouble;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MathUtils {
  public static double doubleFormatter(double value) {
    DecimalFormat df = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.US));
    df.setRoundingMode(RoundingMode.HALF_DOWN);
    String valorFormatado = df.format(value).replace(",", ".");
    return parseDouble(valorFormatado);
  }
}
