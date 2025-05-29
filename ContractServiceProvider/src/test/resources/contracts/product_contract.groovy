package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

   description "should return all products"
	
	request{
		method GET()
		url "/api/products"
	}
	response{
	 status 200
	 body([
		[id: 1, name: "Product 1", "description 1"],
		[id: 2, name: "Product 2", "description 2"]
	 ])	
	 headers{
		contentType(applicationJson())
	 }
    }
}