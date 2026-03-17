package JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateJson {

	public static void main(String[] args) {

		String payload = """
								{
				  "orderId": "O1001",
				  "orderDate": "2025-05-10",
				  "customer": {
				    "name": "Bob Johnson",
				    "address": {
				      "street": "123 Maple Street",
				      "city": "Anytown",
				      "state": "CA",
				      "zip": "90210"
				    },
				    "contact": {
				      "email": "bob.j@example.com",
				      "phone": "555-4567"
				    }
				  },
				  "items": [
				    {
				      "productId": "P001",
				      "productName": "Laptop",
				      "quantity": 2,
				      "price": 999.99
				    },
				    {
				      "productId": "P003",
				      "productName": "Keyboard",
				      "quantity": 1,
				      "price": 75.50
				    }
				  ],
				  "associatedProblems": [
				    {
				      "problemName": "Diabetes",
				      "medications": [
				        {
				          "medicationName": "Aspirin",
				          "dose": "500 mg"
				        },
				        {
				          "medicationName": "Metformin",
				          "dose": "850 mg"
				        }
				      ]
				    }
				  ],
				  "status": "pending"
				}

								""";

		JSONObject jsonObject = new JSONObject(payload);

		JSONArray itemsArray = jsonObject.getJSONArray("items");
		
		for(int i=0;i<itemsArray.length();i++) {
			
			if(itemsArray.getJSONObject(i).has("productName")) {
				
				itemsArray.getJSONObject(i).put("productName", "Desktop");
				
			}
			
			
			
		}
		System.out.println(jsonObject.toString(1));
		
		   
	}

}
