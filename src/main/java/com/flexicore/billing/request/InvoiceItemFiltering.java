package com.flexicore.billing.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.billing.model.ContractItem;
import com.flexicore.billing.model.Invoice;
import com.flexicore.model.FilteringInformationHolder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvoiceItemFiltering extends FilteringInformationHolder {

    private Set<String> invoiceIds=new HashSet<>();
    @JsonIgnore
    private List<Invoice> invoices;

    private Set<String> contractItemIds=new HashSet<>();
    @JsonIgnore
    private List<ContractItem> contractItems;

    public Set<String> getInvoiceIds() {
        return invoiceIds;
    }

    public <T extends InvoiceItemFiltering> T setInvoiceIds(Set<String> invoiceIds) {
        this.invoiceIds = invoiceIds;
        return (T) this;
    }

    @JsonIgnore
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public <T extends InvoiceItemFiltering> T setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
        return (T) this;
    }

    public Set<String> getContractItemIds() {
        return contractItemIds;
    }

    public <T extends InvoiceItemFiltering> T setContractItemIds(Set<String> contractItemIds) {
        this.contractItemIds = contractItemIds;
        return (T) this;
    }

    @JsonIgnore
    public List<ContractItem> getContractItems() {
        return contractItems;
    }

    public <T extends InvoiceItemFiltering> T setContractItems(List<ContractItem> contractItems) {
        this.contractItems = contractItems;
        return (T) this;
    }
}