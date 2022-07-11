package Solid.DIP;


class InterfazUsuario {
    BaseDatos db;

    public InterfazUsuario(BaseDatos database) {
        db = database;
    }

    public void saveEmployeeId(String empId) {
        db.saveEmpIdInDatabase(empId);
    }

    public void setDatabase(BaseDatos database){ db = database;}
}
