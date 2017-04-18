package com.deloitte.crm.transformers;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

/**
 * This class is a MuleSoft Java Transformer. It is used to merge together a
 * list of customers and a list of products, with a many to many relationship:
 * any given customer might have 0, 1, or multiple products associated with it.
 * 
 * There are a list of classes from the <code>com.deloitte.crm.cdm</code>,
 * <code>com.deloitte.productapi.cdm</code>, and
 * <code>com.deloitte.system.customer.cdm</code> packages, because the incoming
 * objects leverage the respective CDMs of the Customer nad Product APIs, while
 * data returned from the CRM API adhere to its API.
 * 
 * @author David Hunter (Deloitte)
 *
 */
public class MergeCustomerAndProductTransformer extends AbstractMessageTransformer {
	/**
	 * Property set by Anypoint (at design time) indicating what
	 * <code>flowVar</code> should be used at runtime to get the list of
	 * <code>Customer</code> objects.
	 */
	private String customerVariable;
	/**
	 * Property set by Anypoint (at design time) indicating what
	 * <code>flowVar</code> should be used at runtime to get the list of
	 * <code>Product</code> objects.
	 */
	private String productVariable;

	/**
	 * Called by MuleSoft when the transformation is to be performed.
	 * 
	 * <ol>
	 * <li>Loops through the incoming Customer objects, and for each one:
	 * <ol>
	 * <li>Populates a target Customer object</li>
	 * <li>Loops through the incoming Product objects, and for each one:
	 * <ol>
	 * <li>if it is one of the Products for the current customer, populates a
	 * target Product object and adds it to the customer</li>
	 * </ol>
	 * </li>
	 * </ol>
	 * </li>
	 * </ol>
	 * 
	 * @param message
	 *            The Mule message object, from which the Customer and Product
	 *            arrays are retrieved.
	 * @param outputEncoding
	 *            Not used
	 * @return A <code>com.deloitte.crm.cdm.Customers</code> object, containing
	 *         the combined data.
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		com.deloitte.system.customer.cdm.Customers incomingCustomers = message.getProperty(this.customerVariable,
				PropertyScope.INVOCATION);
		com.deloitte.productapi.cdm.Products incomingProducts = message.getProperty(this.productVariable,
				PropertyScope.INVOCATION);

		com.deloitte.crm.cdm.Customers outgoingCustomers = new com.deloitte.crm.cdm.Customers();

		for (com.deloitte.system.customer.cdm.Customer c : incomingCustomers.getCustomers()) {
			com.deloitte.crm.cdm.Customer newCust = new com.deloitte.crm.cdm.Customer();
			newCust.setID(c.getId());
			newCust.setFirstName(c.getFirstName());
			newCust.setLastName(c.getLastName());
			newCust.setPhone(c.getPhone());
			newCust.setRegion(c.getRegion());

			for (com.deloitte.system.customer.cdm.Product customerProduct : c.getProducts()) {
				for (com.deloitte.productapi.cdm.Product incomingProduct : incomingProducts.getProducts()) {
					if (customerProduct.getId() == incomingProduct.getID()) {
						com.deloitte.crm.cdm.Product newP = new com.deloitte.crm.cdm.Product();
						newP.setID(incomingProduct.getID());
						newP.setName(incomingProduct.getName());
						newP.setDescription(incomingProduct.getDesc());
						newP.setRegion(incomingProduct.getRegion());
						newP.setPrice(incomingProduct.getPrice());

						newCust.getProducts().add(newP);
					}
				}
			}

			outgoingCustomers.getCustomers().add(newCust);
		}

		return outgoingCustomers;

	}

	public String getCustomerVariable() {
		return customerVariable;
	}

	public void setCustomerVariable(String customerVariable) {
		this.customerVariable = customerVariable;
	}

	public String getProductVariable() {
		return productVariable;
	}

	public void setProductVariable(String productVariable) {
		this.productVariable = productVariable;
	}

}
