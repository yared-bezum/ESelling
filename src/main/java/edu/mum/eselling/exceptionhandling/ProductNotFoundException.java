package edu.mum.eselling.exceptionhandling;



public class ProductNotFoundException extends RuntimeException{
	
	private String productId;
	private String message = "Product Not Found for this ID ";
	
	
 	public ProductNotFoundException() {}
	
	public ProductNotFoundException(String productId, String message) {
		this.productId = productId;

		if (message != null) this.message = message;
		
	}
	
	public String getFullMessage() {
		return (message + productId);
	}
	
	public String getProductId() {
		return productId;
	}
	
@Override
public String getLocalizedMessage() {
	// TODO Auto-generated method stub
	return super.getLocalizedMessage();
}


}
