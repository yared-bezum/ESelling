package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Component;

@Component
public class Cart implements Serializable {

	private static final long serialVersionUID = -6212595579666071819L;

	private Map<Product, Integer> cartProducts = new HashMap<Product, Integer>();
	private BigDecimal grandTotal;
	private int numberOfProducts;
	
	public Cart() {
		super();
		grandTotal = new BigDecimal(0);
		numberOfProducts = 0;
	}

    public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(this.cartProducts);
    }

    
    
    public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void addProduct(Product product) {
        if (this.cartProducts.containsKey(product)) {
            int quantity = this.cartProducts.get(product);
            quantity++;
            this.cartProducts.put(product, quantity);
            numberOfProducts += 1;
            grandTotal = grandTotal.add(product.getUnitPrice().multiply(new BigDecimal(1)));
        } else {
        	System.out.println("Key not contained");
            this.cartProducts.put(product, 1);
            grandTotal = grandTotal.add(product.getUnitPrice().multiply(new BigDecimal(1)));
            numberOfProducts += 1;
        }
        
    }

    public void removeProduct(Product product) {
        this.cartProducts.remove(product);
    }

    public void clear() {
        this.cartProducts.clear();
        this.setGrandTotal(new BigDecimal(0));
        this.numberOfProducts = 0;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
        builder.append("cartProducts", this.cartProducts.keySet());
        return ToStringBuilder.reflectionToString(this);
    }

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

}
