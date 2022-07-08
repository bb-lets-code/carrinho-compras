package br.shop.bb.enums;

public enum TypeDatabase {
    
    EM_MEMORY("EM_MEMORIA"),
    MYSQL("MYSQL"),;

    private final String databaseType;

    private TypeDatabase(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public String[] getAllDatabaseTypes() {
        String[] databaseTypes = new String[TypeDatabase.values().length];
        for (int i = 0; i < databaseTypes.length; i++) {
            databaseTypes[i] = TypeDatabase.values()[i].getDatabaseType();
        }
        return databaseTypes;
    }
}
