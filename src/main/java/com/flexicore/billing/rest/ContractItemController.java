package com.flexicore.billing.rest;

import com.flexicore.annotations.IOperation;
import com.flexicore.annotations.OperationsInside;


import com.flexicore.billing.model.ContractItem;
import com.flexicore.billing.model.ContractItem_;
import com.flexicore.billing.request.ContractItemCreate;
import com.flexicore.billing.request.ContractItemFiltering;
import com.flexicore.billing.request.ContractItemUpdate;
import com.flexicore.billing.service.ContractItemService;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.flexicore.security.SecurityContextBase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@OperationsInside

@RequestMapping("/plugins/ContractItem")

@Tag(name = "ContractItem")
@Extension
@RestController
public class ContractItemController implements Plugin {

		@Autowired
	private ContractItemService service;



	@Operation(summary = "getAllContractItems", description = "Lists all ContractItems")
	@IOperation(Name = "getAllContractItems", Description = "Lists all ContractItems")
	@PostMapping("/getAllContractItems")
	public PaginationResponse<ContractItem> getAllContractItems(

			@RequestBody ContractItemFiltering filtering, @RequestAttribute SecurityContextBase securityContext) {
		service.validateFiltering(filtering, securityContext);
		return service.getAllContractItems(securityContext, filtering);
	}



	@PostMapping("/createContractItem")
	@Operation(summary = "createContractItem", description = "Creates ContractItem")
	@IOperation(Name = "createContractItem", Description = "Creates ContractItem")
	public ContractItem createContractItem(

			@RequestBody ContractItemCreate creationContainer,
			@RequestAttribute SecurityContextBase securityContext) {
		service.validate(creationContainer, securityContext);

		return service.createContractItem(creationContainer, securityContext);
	}



	@PutMapping("/updateContractItem")
	@Operation(summary = "updateContractItem", description = "Updates ContractItem")
	@IOperation(Name = "updateContractItem", Description = "Updates ContractItem")
	public ContractItem updateContractItem(

			@RequestBody ContractItemUpdate updateContainer,
			@RequestAttribute SecurityContextBase securityContext) {
		service.validate(updateContainer, securityContext);
		ContractItem contractItem = service.getByIdOrNull(updateContainer.getId(),
				ContractItem.class, ContractItem_.security, securityContext);
		if (contractItem == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"no ContractItem with id "
					+ updateContainer.getId());
		}
		updateContainer.setContractItem(contractItem);

		return service.updateContractItem(updateContainer, securityContext);
	}
}