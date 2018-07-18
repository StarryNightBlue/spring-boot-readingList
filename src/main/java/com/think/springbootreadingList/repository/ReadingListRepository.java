/**
 * @author StarryNight
 * @date 2018年4月20日 
 */
package com.think.springbootreadingList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.think.springbootreadingList.entity.Book;

/**
 * @author StarryNight
 * @data 2018年4月20日 下午5:01:42
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

	List<Book> findByReader(String reader);

}
