package com.d3snik.AudioConvert.Services;

import org.springframework.stereotype.Service;

@Service
public class AudioConvertService {

	public String convertToAudio(String videoUrl) {
		try {
			ProcessBuilder dowloadBuilder = new ProcessBuilder(
				"yt-dpl", videoUrl, "-o", "video.mp4");
			dowloadBuilder.start().waitFor();
			
			ProcessBuilder convertBuilder = new ProcessBuilder(
					"ffmpeg", "-i", "video.mp4", "audio.mp3");
			convertBuilder.start().waitFor();
			
			return "audio.mp3";
		} catch (Exception e) {
			throw new RuntimeException("Error c	onverting the video" + e.getMessage());
		}
	}
}
