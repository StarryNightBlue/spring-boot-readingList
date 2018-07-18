/**
 * @author StarryNight
 * @date 2018年4月20日 
 */
package com.think.springbootreadingList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.think.springbootreadingList.entity.AmazonProperties;
import com.think.springbootreadingList.entity.Book;
import com.think.springbootreadingList.repository.ReadingListRepository;

/**
 * @author StarryNight
 * @data 2018年4月20日 下午5:12:25
 */
@Controller
@RequestMapping("/readingList")
//@RequestMapping("/")
// @ConfigurationProperties(prefix = "amazon")
public class ReadingListController {

	// private String associateId;// 属性注入

	private AmazonProperties amazonProperties;

	// public void setAssociateId(String associateId) {// associateId 的setter方法
	// this.associateId = associateId;
	// }

	private ReadingListRepository readingListRepository;

	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {// 注入amazonProperties
		this.readingListRepository = readingListRepository;
		this.amazonProperties = amazonProperties;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String readersBooks(String reader, Model model) {
		List<Book> readingList = readingListRepository.findByReader(reader);
		if (readingList != null) {
			model.addAttribute("books", readingList);
			model.addAttribute("reader", reader);
			// model.addAttribute("amazonID", associateId);// 将associateId 放入模型
			model.addAttribute("amazonID", amazonProperties.getAssociateId());// 向模型中添加AssociateId
		}
		return "readingList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addToReadingList(String reader, Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:/readingList";	
	}
}
