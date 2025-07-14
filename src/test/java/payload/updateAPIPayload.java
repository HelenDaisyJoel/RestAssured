package payload;

public class updateAPIPayload {
	public static String updatePlace(String placeID, String updatedAddress)
	{
		return "{\r\n"
				+ "\"place_id\":\""+placeID+"\",\r\n"
				+ "\"address\":\""+updatedAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";
		
	}

	
	
}
