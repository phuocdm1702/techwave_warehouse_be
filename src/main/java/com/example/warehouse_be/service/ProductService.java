package com.example.warehouse_be.service;

import com.example.warehouse_be.entity.Area;
import com.example.warehouse_be.entity.ProductEntity.Product;
import com.example.warehouse_be.model.response.ProductDetailResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList = new ArrayList<>();

    @Autowired
    private AreaService areaService;

    public ProductService() {
    }

    @PostConstruct
    public void init() {
        initData();
    }

    private void initData() {
        List<Area> areas = areaService.getAreaList();

        // === AREA 1 (id=1): Cotton fabric area ===
        productList.add(Product.builder()
                .productId(1)
                .productCode("SP00001")
                .productName("Vải cotton thun 40s")
                .serialNumber("VCOT001")
                .currentStock(1500)
                .lowStockThreshold(50)
                .maxStockThreshold(200)
                .unitPrice(85000.0)
                .createdDate(Date.valueOf("2024-01-15"))
                .updatedDate(Date.valueOf("2024-05-20"))
                .area(areas.get(0)) // Area 1
                .build());

        productList.add(Product.builder()
                .productId(2)
                .productCode("SP00002")
                .productName("Vải cotton lạnh 60s")
                .serialNumber("VCOT002")
                .currentStock(2200)
                .lowStockThreshold(100)
                .maxStockThreshold(300)
                .unitPrice(120000.0)
                .createdDate(Date.valueOf("2024-02-10"))
                .updatedDate(Date.valueOf("2024-06-15"))
                .area(areas.get(0)) // Area 1
                .build());

        productList.add(Product.builder()
                .productId(3)
                .productCode("SP00003")
                .productName("Vải cotton pima cao cấp")
                .serialNumber("VCOT003")
                .currentStock(800)
                .lowStockThreshold(30)
                .maxStockThreshold(150)
                .unitPrice(250000.0)
                .createdDate(Date.valueOf("2024-03-05"))
                .updatedDate(Date.valueOf("2024-07-10"))
                .area(areas.get(0)) // Area 1
                .build());

        productList.add(Product.builder()
                .productId(4)
                .productCode("SP00004")
                .productName("Vải cotton organic")
                .serialNumber("VCOT004")
                .currentStock(600)
                .lowStockThreshold(20)
                .maxStockThreshold(100)
                .unitPrice(180000.0)
                .createdDate(Date.valueOf("2024-04-12"))
                .updatedDate(Date.valueOf("2024-08-18"))
                .area(areas.get(0)) // Area 1
                .build());

        productList.add(Product.builder()
                .productId(5)
                .productCode("SP00005")
                .productName("Vải cotton jersey")
                .serialNumber("VCOT005")
                .currentStock(1800)
                .lowStockThreshold(70)
                .maxStockThreshold(250)
                .unitPrice(95000.0)
                .createdDate(Date.valueOf("2024-05-25"))
                .updatedDate(Date.valueOf("2024-09-30"))
                .area(areas.get(0)) // Area 1
                .build());

        // === AREA 2 (id=2): Kaki/Jeans fabric area ===
        productList.add(Product.builder()
                .productId(6)
                .productCode("SP00006")
                .productName("Vải kaki mềm 8oz")
                .serialNumber("VKAK001")
                .currentStock(1200)
                .lowStockThreshold(60)
                .maxStockThreshold(180)
                .unitPrice(95000.0)
                .createdDate(Date.valueOf("2024-02-20"))
                .updatedDate(Date.valueOf("2024-06-25"))
                .area(areas.get(1)) // Area 2
                .build());

        productList.add(Product.builder()
                .productId(7)
                .productCode("SP00007")
                .productName("Vải jeans denim 12oz")
                .serialNumber("VJEA001")
                .currentStock(1800)
                .lowStockThreshold(80)
                .maxStockThreshold(250)
                .unitPrice(150000.0)
                .createdDate(Date.valueOf("2024-03-15"))
                .updatedDate(Date.valueOf("2024-07-20"))
                .area(areas.get(1)) // Area 2
                .build());

        productList.add(Product.builder()
                .productId(8)
                .productCode("SP00008")
                .productName("Vải kaki co giãn 4 chiều")
                .serialNumber("VKAK002")
                .currentStock(900)
                .lowStockThreshold(40)
                .maxStockThreshold(120)
                .unitPrice(135000.0)
                .createdDate(Date.valueOf("2024-04-10"))
                .updatedDate(Date.valueOf("2024-08-15"))
                .area(areas.get(1)) // Area 2
                .build());

        productList.add(Product.builder()
                .productId(9)
                .productCode("SP00009")
                .productName("Vải jeans stretch")
                .serialNumber("VJEA002")
                .currentStock(1100)
                .lowStockThreshold(55)
                .maxStockThreshold(160)
                .unitPrice(165000.0)
                .createdDate(Date.valueOf("2024-05-18"))
                .updatedDate(Date.valueOf("2024-09-23"))
                .area(areas.get(1)) // Area 2
                .build());

        productList.add(Product.builder()
                .productId(10)
                .productCode("SP00010")
                .productName("Vải kaki dày 10oz")
                .serialNumber("VKAK003")
                .currentStock(1400)
                .lowStockThreshold(65)
                .maxStockThreshold(190)
                .unitPrice(125000.0)
                .createdDate(Date.valueOf("2024-06-22"))
                .updatedDate(Date.valueOf("2024-10-27"))
                .area(areas.get(1)) // Area 2
                .build());

        // === AREA 3 (id=3): Silk/Voan fabric area ===
        productList.add(Product.builder()
                .productId(11)
                .productCode("SP00011")
                .productName("Vải lụa tơ tằm 100%")
                .serialNumber("VLUA001")
                .currentStock(500)
                .lowStockThreshold(20)
                .maxStockThreshold(80)
                .unitPrice(450000.0)
                .createdDate(Date.valueOf("2024-01-25"))
                .updatedDate(Date.valueOf("2024-05-30"))
                .area(areas.get(2)) // Area 3
                .build());

        productList.add(Product.builder()
                .productId(12)
                .productCode("SP00012")
                .productName("Vải voan mỏng")
                .serialNumber("VVOAN001")
                .currentStock(1100)
                .lowStockThreshold(35)
                .maxStockThreshold(140)
                .unitPrice(75000.0)
                .createdDate(Date.valueOf("2024-02-28"))
                .updatedDate(Date.valueOf("2024-07-03"))
                .area(areas.get(2)) // Area 3
                .build());

        productList.add(Product.builder()
                .productId(13)
                .productCode("SP00013")
                .productName("Vải lụa satin")
                .serialNumber("VLUA002")
                .currentStock(700)
                .lowStockThreshold(25)
                .maxStockThreshold(100)
                .unitPrice(320000.0)
                .createdDate(Date.valueOf("2024-03-22"))
                .updatedDate(Date.valueOf("2024-08-27"))
                .area(areas.get(2)) // Area 3
                .build());

        productList.add(Product.builder()
                .productId(14)
                .productCode("SP00014")
                .productName("Vải voan ren")
                .serialNumber("VVOAN002")
                .currentStock(800)
                .lowStockThreshold(30)
                .maxStockThreshold(110)
                .unitPrice(95000.0)
                .createdDate(Date.valueOf("2024-04-17"))
                .updatedDate(Date.valueOf("2024-09-22"))
                .area(areas.get(2)) // Area 3
                .build());

        productList.add(Product.builder()
                .productId(15)
                .productCode("SP00015")
                .productName("Vải lụa chiffon")
                .serialNumber("VLUA003")
                .currentStock(600)
                .lowStockThreshold(22)
                .maxStockThreshold(90)
                .unitPrice(280000.0)
                .createdDate(Date.valueOf("2024-05-30"))
                .updatedDate(Date.valueOf("2024-11-04"))
                .area(areas.get(2)) // Area 3
                .build());

        // === AREA 4 (id=4): Wool/Fleece fabric area ===
        productList.add(Product.builder()
                .productId(16)
                .productCode("SP00016")
                .productName("Vải len cashmere")
                .serialNumber("VLEN001")
                .currentStock(400)
                .lowStockThreshold(15)
                .maxStockThreshold(60)
                .unitPrice(680000.0)
                .createdDate(Date.valueOf("2024-04-05"))
                .updatedDate(Date.valueOf("2024-09-10"))
                .area(areas.get(3)) // Area 4
                .build());

        productList.add(Product.builder()
                .productId(17)
                .productCode("SP00017")
                .productName("Vải nỉ bông dày")
                .serialNumber("VNI001")
                .currentStock(1600)
                .lowStockThreshold(70)
                .maxStockThreshold(220)
                .unitPrice(125000.0)
                .createdDate(Date.valueOf("2024-05-12"))
                .updatedDate(Date.valueOf("2024-10-17"))
                .area(areas.get(3)) // Area 4
                .build());

        productList.add(Product.builder()
                .productId(18)
                .productCode("SP00018")
                .productName("Vải len merino")
                .serialNumber("VLEN002")
                .currentStock(600)
                .lowStockThreshold(25)
                .maxStockThreshold(90)
                .unitPrice(420000.0)
                .createdDate(Date.valueOf("2024-06-18"))
                .updatedDate(Date.valueOf("2024-11-23"))
                .area(areas.get(3)) // Area 4
                .build());

        productList.add(Product.builder()
                .productId(19)
                .productCode("SP00019")
                .productName("Vải nỉ mỏng")
                .serialNumber("VNI002")
                .currentStock(1300)
                .lowStockThreshold(50)
                .maxStockThreshold(170)
                .unitPrice(98000.0)
                .createdDate(Date.valueOf("2024-07-24"))
                .updatedDate(Date.valueOf("2024-12-29"))
                .area(areas.get(3)) // Area 4
                .build());

        productList.add(Product.builder()
                .productId(20)
                .productCode("SP00020")
                .productName("Vải len alpaca")
                .serialNumber("VLEN003")
                .currentStock(350)
                .lowStockThreshold(12)
                .maxStockThreshold(55)
                .unitPrice(750000.0)
                .createdDate(Date.valueOf("2024-08-29"))
                .updatedDate(Date.valueOf("2025-02-03"))
                .area(areas.get(3)) // Area 4
                .build());

        // === AREA 5 (id=5): Special fabric area ===
        productList.add(Product.builder()
                .productId(21)
                .productCode("SP00021")
                .productName("Vải da PU cao cấp")
                .serialNumber("VDA001")
                .currentStock(300)
                .lowStockThreshold(10)
                .maxStockThreshold(50)
                .unitPrice(520000.0)
                .createdDate(Date.valueOf("2024-07-25"))
                .updatedDate(Date.valueOf("2024-12-30"))
                .area(areas.get(4)) // Area 5
                .build());

        productList.add(Product.builder()
                .productId(22)
                .productCode("SP00022")
                .productName("Vải lưới thể thao")
                .serialNumber("VLUOI001")
                .currentStock(850)
                .lowStockThreshold(30)
                .maxStockThreshold(110)
                .unitPrice(88000.0)
                .createdDate(Date.valueOf("2024-08-14"))
                .updatedDate(Date.valueOf("2025-01-19"))
                .area(areas.get(4)) // Area 5
                .build());

        productList.add(Product.builder()
                .productId(23)
                .productCode("SP00023")
                .productName("Vải thun polyester")
                .serialNumber("VPOLY001")
                .currentStock(2000)
                .lowStockThreshold(90)
                .maxStockThreshold(280)
                .unitPrice(65000.0)
                .createdDate(Date.valueOf("2024-09-09"))
                .updatedDate(Date.valueOf("2025-02-14"))
                .area(areas.get(4)) // Area 5
                .build());

        productList.add(Product.builder()
                .productId(24)
                .productCode("SP00024")
                .productName("Vải nỉ lông cừu")
                .serialNumber("VNI003")
                .currentStock(450)
                .lowStockThreshold(18)
                .maxStockThreshold(70)
                .unitPrice(320000.0)
                .createdDate(Date.valueOf("2024-10-11"))
                .updatedDate(Date.valueOf("2025-03-16"))
                .area(areas.get(4)) // Area 5
                .build());

        productList.add(Product.builder()
                .productId(25)
                .productCode("SP00025")
                .productName("Vải canvas")
                .serialNumber("VCAN001")
                .currentStock(950)
                .lowStockThreshold(40)
                .maxStockThreshold(130)
                .unitPrice(115000.0)
                .createdDate(Date.valueOf("2024-11-20"))
                .updatedDate(Date.valueOf("2025-04-25"))
                .area(areas.get(4)) // Area 5
                .build());
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product addProduct(Product product) {
        // Auto increment ID
        Integer newId = productList.stream()
                .mapToInt(Product::getProductId)
                .max()
                .orElse(0) + 1;
        product.setProductId(newId);

        // Set created/updated dates
        if (product.getCreatedDate() == null) {
            product.setCreatedDate(new Date(System.currentTimeMillis()));
        }
        product.setUpdatedDate(new Date(System.currentTimeMillis()));

        productList.add(product);
        return product;
    }

    public List<ProductDetailResponse> getAllProductDetails() {
        return productList.stream()
                .map(ProductDetailResponse::new)
                .toList();
    }

    public ProductDetailResponse getProductDetailById(Integer id) {
        Product product = getProductById(id);
        return product != null ? new ProductDetailResponse(product) : null;
    }

    public List<ProductDetailResponse> getProductDetailsByAreaId(Integer areaId) {
        return productList.stream()
                .filter(product -> product.getArea() != null &&
                        product.getArea().getAreaId().equals(areaId))
                .map(ProductDetailResponse::new)
                .toList();
    }

    public Product getProductById(Integer id) {
        return productList.stream()
                .filter(product -> product.getProductId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product findByProductCode(String productCode) {
        return productList.stream()
                .filter(product -> product.getProductCode().equalsIgnoreCase(productCode))
                .findFirst()
                .orElse(null);
    }
}
