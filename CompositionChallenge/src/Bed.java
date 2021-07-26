public class Bed {
    private int bedWidth;
    private int bedHeight;
    private String bedType;

    public Bed(int bedWidth, int bedHeight, String bedType) {
        this.bedWidth = bedWidth;
        this.bedHeight = bedHeight;
        if(bedType.equalsIgnoreCase("King Size") || bedType.equalsIgnoreCase("Queen Size")) {
            this.bedType = bedType;
        }
        else {
            System.out.println("Undefined Type is Assigned. Default Value King Size Assigned");
            this.bedType = "King Size";
        }

    }

    public void returnBedSize() {
        System.out.println("The Size of Bed is " + bedWidth + " x " + bedHeight);
    }

    public int getBedWidth() {
        return bedWidth;
    }

    public void setBedWidth(int bedWidth) {
        this.bedWidth = bedWidth;
    }

    public int getBedHeight() {
        return bedHeight;
    }

    public void setBedHeight(int bedHeight) {
        this.bedHeight = bedHeight;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
}
