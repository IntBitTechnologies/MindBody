/**
 * 
 */
package com.mindbody.source;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.mindbodyonline.clients.api._0_5.SelectDataCSVResult;

/**
 * @author AR
 *
 */
public class SalesDetailResponse extends BaseResponse {

	/**
	 * @param selectDataCSVResult
	 */
	public SalesDetailResponse(SelectDataCSVResult selectDataCSVResult) {
		super(selectDataCSVResult);
		// TODO Auto-generated constructor stub
	}

	public static SalesDetailResponse parse(
			SelectDataCSVResult selectDataCSVResult) throws IOException {
		SalesDetailResponse response = new SalesDetailResponse(
				selectDataCSVResult);
		if (!MindBodyUtil.isEmpty(selectDataCSVResult.getCSV())) {
			List<SalesDetail> list = new ArrayList<SalesDetail>();
			StringReader stringReader = MindBodyUtil.parseCSV(selectDataCSVResult);
			CsvReader csvReader = new CsvReader(stringReader);
			csvReader.readHeaders();
			while (csvReader.readRecord()) {
				SalesDetail salesDetail = SalesDetail.parse(csvReader);
				list.add(salesDetail);
			}
			csvReader.close();
			response.setRows(list);	
		}
		
		return response;
	}

}
