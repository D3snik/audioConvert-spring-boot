package com.d3snik.AudioConvert.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d3snik.AudioConvert.Services.AudioConvertService;

@RestController
@RequestMapping("/api/converter")
public class AudioConvertController {

	private final AudioConvertService audioConvertService;

	public AudioConvertController(AudioConvertService audioConvertService) {
		this.audioConvertService = audioConvertService;
	}
	
	@PostMapping
	public ResponseEntity<String> convertVideoToAudio(@RequestBody Map<String, String> request) {
		String videoUrl = request.get("url");
		
		String audioPath = audioConvertService.convertToAudio(videoUrl);
		
		return ResponseEntity.ok("Audio salvo : " + audioPath);
	}
}
