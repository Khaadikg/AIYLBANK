package com.aiylbank.demo.web;

import com.aiylbank.demo.model.task.service.TaskService;
import com.aiylbank.demo.web.common.BaseEntityController;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/service/tasks")
public class TaskController extends BaseEntityController {

    private final TaskService taskService;

    @PostMapping(value = "/find-by-id/{id}")
    public ResponseEntity<?> updateFromBi(@PathVariable @Min(0) Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@PathVariable @Min(0) Long id) {
        return ResponseEntity.ok(taskService.delete(id));
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable @Min(0) Long id,
                                    @RequestParam @NotBlank String description) {
        return ResponseEntity.ok(taskService.update(id, description));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestParam @NotBlank String description) {
        return ResponseEntity.ok(taskService.save(description));
    }
}
