public class Pilot extends Person{
    private int pilotNum;
    private int licenseNum;
    public Pilot(String name, int age, int pilotNum, int licenseNum){
        super(name, age);
        this.pilotNum=pilotNum;
        this.licenseNum=licenseNum;
    }
    public String info(){
        String toString=super.info();
        return toString + "\nPilot number: "+pilotNum+"\nPilot's license number: "+licenseNum;
    }

    public int getPilotNum() {
        return pilotNum;
    }

    public void setPilotNum(int pilotNum) {
        this.pilotNum = pilotNum;
    }

    public int getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(int licenseNum) {
        this.licenseNum = licenseNum;
    }
}
