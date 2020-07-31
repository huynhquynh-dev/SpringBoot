package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.api.output.NewOutput;
import com.laptrinhjavaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.laptrinhjavaweb.dto.NewDto;

// @RestController = @Controller + @ResponseBody
// @PostMapping    = @RequestMapping + method POST

// Cơ chế phân trang
// Client gửi về: page, limit
// Server trả giá trị: page, totalItem, List<NewDto>

// page (trang đang đứng),
// totalPage (Tổng số trang: được chia từ tổng list và limit),
// List<NewDto> (số lượng dữ liệu lấy lên từ database)
// Limit: Tổng số item trên 1 trang
// totalItem(): đếm số lượng item trong list lấy đc từ database

@CrossOrigin
@RestController
public class NewAPI {

	@Autowired
	private INewService newService;

//	Cách 1
	@GetMapping("/new")
	public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page,
							 @RequestParam(value = "limit", required = false) Integer limit) {
		NewOutput newOutput = new NewOutput();
		if(page != null && limit != null) {
			newOutput.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			newOutput.setListResult(newService.findAll(pageable));
			newOutput.setTotalPage((int) Math.ceil((double) (newService.totalItem())/limit));
		}
		else {
			newOutput.setListResult(newService.findAll());
		}
		return newOutput;
	}

// Cách 2
//	@GetMapping("/new")
//	public NewOutput showNew(@RequestParam(value = "page", defaultValue = "NONE") String pageStr,
//							 @RequestParam(value = "limit", defaultValue = "NONE") String limitStr) {
//		NewOutput newOutput = new NewOutput();
//		if(!pageStr.equals("NONE") && !limitStr.equals("NONE")) {
//			int page = Integer.parseInt(pageStr);
//			int limit = Integer.parseInt(limitStr);
//			newOutput.setPage(page);
//			Pageable pageable = new PageRequest(page - 1, limit);
//			newOutput.setListResult(newService.findAll(pageable));
//			newOutput.setTotalPage((int) Math.ceil((double) (newService.totalItem())/limit));
//		}
//		else {
//			newOutput.setListResult(newService.findAll());
//		}
//		return newOutput;
//	}

	@PostMapping("/new")
	public NewDto createNew(@RequestBody NewDto model) {
		return newService.save(model);
	}
	
	@PutMapping("/new/{id}")
	public NewDto updateNew(@RequestBody NewDto model, @PathVariable("id") Long id) {
		model.setId(id);
		return newService.save(model);
	}
	
	@DeleteMapping("/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}
}
