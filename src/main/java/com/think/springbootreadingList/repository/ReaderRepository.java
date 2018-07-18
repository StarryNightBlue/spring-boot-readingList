/**
 * @author StarryNight
 * @date 2018年4月28日 
 */
package com.think.springbootreadingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.think.springbootreadingList.entity.Reader;

/**
 * @author StarryNight
 * @data 2018年4月28日 上午10:11:48
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {

}
