import java.util.Objects;

public class Laptop {
    private String producer;
    private int volumeRAM;
    private String typeOS;
    private int volumeHDD;
    private  String color;

    public Laptop(String producer, int volumeRAM, String typeOS, int volumeHDD, String color) {
        if (producer.length()==0){
            this.producer="None";
        }else {
            this.producer = producer;
        }
        if (volumeRAM==0){
            this.volumeRAM = 0;
        }else {
            this.volumeRAM = volumeRAM;
        }
        if (typeOS.length()==0){
            this.typeOS = "None";
        }else{
            this.typeOS = typeOS;
        }
        if (volumeHDD==0){
            this.volumeHDD = 0;
        }else {
            this.volumeHDD = volumeHDD;
        }
        if (color.length()==0){
            this.color = "None";
        }else {
            this.color = color;
        }
    }

    public String getProducer() {
        return producer;
    }

    public int getVolumeRAM() {
        return volumeRAM;
    }

    public String getTypeOS() {
        return typeOS;
    }

    public int getVolumeHDD() {
        return volumeHDD;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "producer='" + producer + '\'' +
                ", volumeRAM=" + volumeRAM +
                ", typeOS='" + typeOS + '\'' +
                ", volumeHDD=" + volumeHDD +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return volumeRAM == laptop.volumeRAM && volumeHDD == laptop.volumeHDD &&
                producer.equals(laptop.producer) && typeOS.equals(laptop.typeOS) &&
                color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, volumeRAM, typeOS, volumeHDD, color);
    }
}
