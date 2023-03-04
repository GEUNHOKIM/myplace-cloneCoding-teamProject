package com.myplace.myplace.like.controller;


import com.myplace.myplace.common.SuccessResponseDto;
import com.myplace.myplace.like.dto.LikeResponseDto;
import com.myplace.myplace.like.service.LikeService;
import com.myplace.myplace.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PutMapping("/api/reviews/{id}")
    public SuccessResponseDto<Void> likeReview(@PathVariable Long id,
                                                         @RequestBody LikeResponseDto likeRequestDto,
                                                         @AuthenticationPrincipal UserDetailsImpl userDetails){
            return likeService.likeReview(id, likeRequestDto, userDetails.getUser());
    }
}
