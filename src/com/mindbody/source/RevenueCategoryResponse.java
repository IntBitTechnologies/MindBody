package com.mindbody.source;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.mindbodyonline.clients.api._0_5.SelectDataCSVResult;

public class RevenueCategoryResponse extends BaseResponse {
	
	public RevenueCategoryResponse(SelectDataCSVResult selectDataCSVResult) {
		super(selectDataCSVResult);
	}

	public static RevenueCategoryResponse parse(
			SelectDataCSVResult selectDataCSVResult) throws IOException {
		RevenueCategoryResponse revenueCategoryResponse = new RevenueCategoryResponse(
				selectDataCSVResult);
		if (!MindBodyUtil.isEmpty(selectDataCSVResult.getCSV())) {
			List<RevenueCategory> revenueCategories = new ArrayList<RevenueCategory>();
			StringReader stringReader = MindBodyUtil
					.parseCSV(selectDataCSVResult);
			CsvReader csvReader = new CsvReader(stringReader);
			csvReader.readHeaders();
			while (csvReader.readRecord()) {
				RevenueCategory revenueCategory = RevenueCategory
						.parse(csvReader);
				revenueCategories.add(revenueCategory);
			}
			csvReader.close();
			revenueCategoryResponse.setRows(revenueCategories);
		}
		return revenueCategoryResponse;
	}

}
