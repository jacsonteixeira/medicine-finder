package com.bionexo.util.enums;

public enum SupplierType {
    BEST_SUPPLIER("Best Supplier"), WORSE_SUPPLIER("Worse Supplier");

    private String supplierName;

    private SupplierType(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }
}
