package com.entity;

/**
 * Created by tony.duan on 5/26/16.
 */
public class BookNativeSql {

	public static final String GET_TOP_BOOKS_FOR_CATEGORY ="SELECT a.*\n" +
			"FROM ishare.book a \n" +
			"LEFT JOIN ishare.book b \n" +
			"ON a.bookCategoryId = b.bookCategoryId \n" +
			"AND a.downloadFrequency < b.downloadFrequency \n" +
			"AND b.usable = 1 \n" +
			"WHERE a.usable = 1 \n" +
			"GROUP BY a.bookId , a.bookCategoryId , a.downloadFrequency \n" +
			"HAVING COUNT(b.bookId) < :topNumberForCategory \n" +
			"ORDER BY a.bookCategoryId , a.downloadFrequency DESC;";



	public static final String GET_TOP_BOOKS_FOR_ALL ="select * from ishare.book a order by a.downloadFrequency desc limit 0,:topNumberForAllBooks ;";

	public static final String GET_BOOK_CATEGORY ="SELECT t.bookCategoryId,t.categoryName FROM ishare.book_category t;";

	public static final String GET_CATEGORY_BOOKS ="select * from ishare.book a where a.bookCategoryId =:categoryId order by a.downloadFrequency desc limit :startNumber,:pageSize ;";

	public static final String GET_SEARCH_BOOKS ="select * from ishare.book a where 1=1 \n" +
			"AND IF(:bookName IS NULL,TRUE,a.bookName =:bookName)\n"+
			"order by a.downloadFrequency desc \n" +
			"limit :startNumber,:pageSize ;";
}
