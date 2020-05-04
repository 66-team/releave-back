package br.com.megahack.releave.controller;

import br.com.megahack.releave.model.ProductStorage;
import br.com.megahack.releave.model.dto.request.ProductRequestDto;
import br.com.megahack.releave.model.dto.response.IdResponse;
import br.com.megahack.releave.service.ProductService;
import br.com.megahack.releave.service.ProductStorageService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/product")
public class ProductStorageController {

  private final ProductService productService;
  private final ProductStorageService productStorageService;

  @PostMapping
  public ResponseEntity<IdResponse> save(@RequestBody @Valid ProductRequestDto dto) {
    ProductStorage product = productService.saveRequest(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(product.getId())
        .toUri();
    return ResponseEntity.created(uri).body(new IdResponse(product.getId()));
  }

  @GetMapping
  public ResponseEntity<List<ProductStorage>> findAll() {
    return ResponseEntity.ok(productStorageService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductStorage> findById(@PathVariable("id") String id) {
    return ResponseEntity.ok(productStorageService.findById(id));
  }

}
