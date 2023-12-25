import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Material> materials = new ArrayList<>();

        // Tạo 5 đối tượng bột
        materials.add(new CrispyFlour("CF1", "Crispy Flour 1", LocalDate.now(), 10, 2));
        materials.add(new CrispyFlour("CF2", "Crispy Flour 2", LocalDate.now(), 100, 4));
        materials.add(new CrispyFlour("CF3", "Crispy Flour 3", LocalDate.now(), 1000, 2));
        materials.add(new CrispyFlour("CF4", "Crispy Flour 4", LocalDate.now(), 20, 3));
        // Tạo 5 đối tượng thịt
        materials.add(new Meat("M1", "Meat 1", LocalDate.now(), 50, 2.5));
        materials.add(new Meat("M2", "Meat 2", LocalDate.now(), 60, 3.0));
        materials.add(new Meat("M3", "Meat 3", LocalDate.now(), 45, 2.0));
        materials.add(new Meat("M4", "Meat 4", LocalDate.now(), 55, 2.7));
        materials.add(new Meat("M5", "Meat 5", LocalDate.now(), 70, 3.5));


//        // Tính tổng tiền của tất cả các vật liệu
//        double totalCost = materialManager.calculateTotalCost();
//        System.out.println("Total Cost: " + totalCost);

//        addMaterial(materials);
//        removeMaterialByCode(materials,"2");
//        displayMaterial(materials);
//        String Id = "CF2"; // Id của sản phẩm cần sửa đổi
//        String newName = "New Meat Name";
//        LocalDate newManufacturingDate = LocalDate.now();
//        int newQuantity = 10;
//        int newCost = 100;
//
//        updateProduct(materials, Id, newName, newManufacturingDate, newQuantity, newCost);

        //Sắp xếp
         sortMaterial(materials);

    }

    public static void addMaterial(List<Material> materials) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên ID");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩn");
        String name = scanner.nextLine();
        LocalDate.now();
        System.out.println("Nhập gia của sản phẩm");
        int cost = scanner.nextInt();
        System.out.println("Nhập số lượng");
        int quantity = scanner.nextInt();
        Material material = new CrispyFlour(id, name, LocalDate.now(), cost, quantity);
        materials.add(material);
        displayMaterial(materials);
    }

    public static void displayMaterial(List<Material> materials) {
        for (Material material : materials) {
            System.out.println(material.toString());
        }
    }

    public static void removeMaterialByCode(List<Material> materials, String id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập sản phẩm có ID bạn muốn xóa");
        id = scanner.nextLine();
        for (Material material : materials) {
            if (material.getId().equals(id)) {
                materials.remove(material);
                break;
            }
        }
        displayMaterial(materials);
    }

    public static void updateProduct(List<Material> materials, String Id, String newName, LocalDate newManufacturingDate, int newQuantity, int newCost) {
        for (Material material : materials) {
            if (material instanceof CrispyFlour && material.getId().equals(Id)) {
                CrispyFlour crispyFlour = (CrispyFlour) material;
                crispyFlour.setName(newName);
                crispyFlour.setManufacturingDate(newManufacturingDate);
                crispyFlour.setQuantity(newQuantity);
                crispyFlour.setCost(newCost);
                break;
            } else if (material instanceof Meat && material.getId().equals(Id)) {
                Meat meat = (Meat) material;
                meat.setName(newName);
                meat.setManufacturingDate(newManufacturingDate);
                meat.setCost(newCost);
                break;
            }
        }
        displayMaterial(materials);
    }

    public static void sortMaterial(List<Material> materials) {
        int n = materials.size();
        for (int i = 0; i < materials.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < materials.size(); j++) {
                if (materials.get(j).getCost() < materials.get(minIndex).getCost()) {
                    minIndex = j;
                }
            }
            Collections.swap(materials, i, minIndex);
        }
displayMaterial(materials);
    }

}