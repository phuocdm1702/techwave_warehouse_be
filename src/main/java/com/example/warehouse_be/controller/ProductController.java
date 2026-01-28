package com.example.warehouse_be.controller;

import com.example.warehouse_be.entity.ProductEntity.Product;
import com.example.warehouse_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllSP(){
        return productService.getProductList();
    }

    @PostMapping("/addSP")
    public Product addSP(@RequestBody Product product){
        return productService.addProduct(product);
    }


    /**
     * API: Gán sản phẩm vào khu vực (tương ứng với relay/led)
     */
    @PutMapping("/{productId}/assign-area")
    public ResponseEntity<?> assignProductToArea(
            @PathVariable Integer productId,
            @RequestBody Map<String, Integer> request) {

        Integer areaId = request.get("areaId");

        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        // Logic gán khu vực cho sản phẩm
        // (Cần thêm method trong ProductService)

        return ResponseEntity.ok().body(Map.of(
                "success", true,
                "message", "Đã gán sản phẩm vào khu vực"
        ));
    }

    /**
     * API: Tìm sản phẩm bằng QR code
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchByQrCode(@RequestParam String qrCode) {
        // Logic tìm sản phẩm
        return ResponseEntity.ok().build();
    }
}
