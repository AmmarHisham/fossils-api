package com.fossils.fossils.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fossils.fossils.dto.GEPageDTO;
import com.fossils.fossils.entity.GePage;
import com.fossils.fossils.repository.GEPageRepository;

@RestController
public class GEPageController {

	@Autowired
	GEPageRepository gePageRepository;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping("/api/page/addPage")
	public GePage addPage(@RequestBody GePage gePage) {
		return gePageRepository.save(gePage);

	}

	@GetMapping("/api/page/resultPage")
	public List<GEPageDTO> result() {

		List<GePage> geCategories = gePageRepository.findAll();
		return geCategories.stream().map(category -> convertToDto(category)).collect(Collectors.toList());

	}

	@GetMapping("/api/page/getAllPages")
	public List<GePage> getAllPages() {

		List<GePage> gePages = gePageRepository.findAll();
		return gePages;
	}

	@PutMapping("/api/page/update")
	public GePage createOrUpdatePage(@RequestBody GePage gePage) {
		Optional<GePage> page = gePageRepository.findById(gePage.getId());

		if (page.isPresent()) {
			GePage newEntity = page.get();
			newEntity.setName(gePage.getName());
			newEntity.setFromAge(gePage.getFromAge());
			newEntity.setToAge(gePage.getToAge());
			newEntity.setScaleUnit(gePage.getScaleUnit());

			newEntity = gePageRepository.save(newEntity);

			return newEntity;
		} else {
			gePage = gePageRepository.save(gePage);

			return gePage;
		}
	}

	@DeleteMapping("/api/page/delete/{page_id}")
	public void deletePageById(@PathVariable(value = "page_id") Long page_id) {
		Optional<GePage> category = gePageRepository.findById(page_id);
		if (category.isPresent()) {
			gePageRepository.deleteById(page_id);
		} else {

		}
	}

	private GEPageDTO convertToDto(GePage gePage) {
		modelMapper.getConfiguration().setFieldMatchingEnabled(true)
		  .setFieldAccessLevel(AccessLevel.PRIVATE);
		GEPageDTO gePageDTO = modelMapper.map(gePage, GEPageDTO.class);
		return gePageDTO;
	}

}
