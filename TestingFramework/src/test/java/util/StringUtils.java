package util;

import java.util.Random;

public class StringUtils
{
	private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static Random random = new Random();

	public static String getRandomString(int stringLength)
	{
		StringBuilder stringBuilder = new StringBuilder(stringLength);
		for (int i = 0; i < stringLength; i++)
		{
			stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
		}
		return stringBuilder.toString();
	}

	public static double parsePrice(String priceString) {
		int integerPart = priceString.indexOf(',');
		double priceToReturn = Double.parseDouble(priceString.substring(0, integerPart));
		int floatPart = priceString.indexOf(' ');
		priceToReturn += Double.parseDouble(priceString.substring(integerPart + 1, floatPart));
		return priceToReturn;
	}
}
