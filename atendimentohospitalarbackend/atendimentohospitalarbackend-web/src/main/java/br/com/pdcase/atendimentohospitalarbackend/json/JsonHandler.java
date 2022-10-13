package br.com.pdcase.atendimentohospitalarbackend.json;

/**
 * An abstraction to deal with serialization and deserialization of objects to/from JSON.
 * Reference:
 * http://www.javaindeed.com/getting-started-with-json-b/?elq_mid=69404&sh=2426915128252692422151512815415748&cmid=WWMK160429P00027
 */
public interface JsonHandler {

	/**
	 * Parse an object to JSON format.
	 * @param obj object to be parsed.
	 * @return object parsed.
	 * @throws ParseException when parse cannot be executed.
	 */
	public String toJson(Object obj);

	/**
	 * Parse a JSON string to object.
	 * @param stringObject an object represented by his string format.
	 * @param clazz class reference of string object.
	 * @return an object
	 * @throws ParseException when parse cannot be executed.
	 */
	public Object fromJson(String stringObject, Class<?> clazz);

}
