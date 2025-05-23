package com.zaychik.web.action;

import com.zaychik.backend.match.service.MovementService;
import com.zaychik.backend.user.entity.User;
import com.zaychik.web.action.dto.MoveRequest;
import com.zaychik.web.match.dto.CellResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;

    @PostMapping("/move")
    public ResponseEntity<CellResponse> moveToCell(
            @AuthenticationPrincipal User user,
            @RequestBody MoveRequest request) {
        CellResponse response = movementService.moveToCell(user, request);
        return ResponseEntity.ok(response);
    }
}