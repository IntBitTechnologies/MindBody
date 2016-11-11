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
public class NoReturnDetailResponse extends BaseResponse {
	
	/**
	 * @param selectDataCSVResult
	 */
	public NoReturnDetailResponse(SelectDataCSVResult selectDataCSVResult) {
		super(selectDataCSVResult);
		// TODO Auto-generated constructor stub
	}

	public static NoReturnDetailResponse parse(
			SelectDataCSVResult selectDataCSVResult) throws IOException {
		NoReturnDetailResponse noReturnDetailResponse = new NoReturnDetailResponse(
				selectDataCSVResult);
		if (!MindBodyUtil.isEmpty(selectDataCSVResult.getCSV())) {
			List<NoReturnDetail> list = new ArrayList<NoReturnDetail>();
			StringReader stringReader = MindBodyUtil.parseCSV(selectDataCSVResult);
			CsvReader csvReader = new CsvReader(stringReader);
			csvReader.readHeaders();
			while (csvReader.readRecord()) {
				NoReturnDetail revenueCategory = NoReturnDetail.parse(csvReader);
				list.add(revenueCategory);
			}
			csvReader.close();
			noReturnDetailResponse.setRows(list);	
		}
		
		return noReturnDetailResponse;
	}

}
