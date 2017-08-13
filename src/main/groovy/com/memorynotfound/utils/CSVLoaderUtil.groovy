package com.memorynotfound.utils

import static org.apache.commons.csv.CSVFormat.*

import java.nio.file.Path

import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord

import com.memorynotfound.hibernate.Author
import com.memorynotfound.hibernate.Book
import com.memorynotfound.hibernate.constants.AuthorHeader
import com.memorynotfound.hibernate.constants.BookHeader

class CSVLoaderUtil {
	
	def static loadCSV(File csvFile, Class<?> headerClass) {
		loadCSV(csvFile.toPath(), headerClass)
	}
	
	
	def static loadCSV(Path csvFile, Class<?> headerClass) {
		
		List list = new ArrayList()
		csvFile.withReader{ reader ->
			CSVParser csv = new CSVParser(reader, DEFAULT.withHeader())
			Map<String,Integer> headerMap = csv.getHeaderMap()
			List<CSVRecord> csvRecords = csv.getRecords()
			for (eachCSVRecord in csvRecords) {
				def record
				for(Map.Entry<String,Integer> eachHeader in headerMap.entrySet()) {
					if(headerClass == BookHeader) {
						record = new Book()
						for(each in BookHeader.values()) {
							if(each.getHeaderLabel().equalsIgnoreCase(eachHeader.getKey())) {
								record = each.doSomething(record, eachCSVRecord.get(eachHeader.getValue()))
							}
						}
					}
					else if(headerClass == AuthorHeader) {
						record = new Author()
						for(each in AuthorHeader.values()) {
							if(each.getHeaderLabel().equalsIgnoreCase(eachHeader.getKey())) {
								record = each.doSomething(record, eachCSVRecord.get(eachHeader.getValue()))
							}
						}
					}
				}
				list.add(record)
			}
		}
		return list
	}
	
	def static populateBook(File csvFile, Class<?> headerClass) {
		populateBook(csvFile.toPath(), headerClass)
	}
	
	def static populateBook(Path csvFile, Class<?> headerClass) {
		
		List list = new ArrayList()
		csvFile.withReader{ reader ->
			CSVParser csv = new CSVParser(reader, DEFAULT.withHeader())
			Map<String,Integer> headerMap = csv.getHeaderMap()
			List<CSVRecord> csvRecords = csv.getRecords()
			for (eachCSVRecord in csvRecords) {
				def record = new Book()
				for(Map.Entry<String,Integer> eachHeader in headerMap.entrySet()) {
					for(each in BookHeader.values()) {
						if(each.getHeaderLabel().equalsIgnoreCase(eachHeader.getKey())) {
							record = each.doSomething(record, eachCSVRecord.get(eachHeader.getValue()))
						}
					}
				}
				list.add(record)
			}
		}
		return list
	}
	
	def static populateAuthor(File csvFile, Class<?> headerClass) {
		populateAuthor(csvFile.toPath(), headerClass)
	}
	
	def static populateAuthor(Path csvFile, Class<?> headerClass) {
		
		List list = new ArrayList()
		csvFile.withReader{ reader ->
			CSVParser csv = new CSVParser(reader, DEFAULT.withHeader())
			Map<String,Integer> headerMap = csv.getHeaderMap()
			List<CSVRecord> csvRecords = csv.getRecords()
			for (eachCSVRecord in csvRecords) {
				def record = new Author()
				for(Map.Entry<String,Integer> eachHeader in headerMap.entrySet()) {
					for(each in AuthorHeader.values()) {
						if(each.getHeaderLabel().equalsIgnoreCase(eachHeader.getKey())) {
							record = each.doSomething(record, eachCSVRecord.get(eachHeader.getValue()))
						}
					}
				}
				list.add(record)
			}
		}
		return list
	}
}
