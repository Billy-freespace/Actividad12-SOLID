package NoSolid.ISP;

interface Fax {
    public String stringTypeFax();
}

class LanFax implements Fax {
    @Override
    public String stringTypeFax() {
        return "LanFax";
    }
}

class EFax implements Fax {
    @Override
    public String stringTypeFax() {
        return "EFax";
    }
}
