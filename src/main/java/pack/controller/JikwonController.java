package pack.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.JikwonDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {
	@Autowired
	private JikwonDao jikwonDao;
	
	@RequestMapping("jikwondb")
	public ModelAndView jikwonProcess(HttpServletRequest request) {
		String num = request.getParameter("no");
		ArrayList<JikwonDto> list = jikwonDao.getDataSelect(num);
		
		return new ModelAndView("jikwon", "datase", list);
	}
}
