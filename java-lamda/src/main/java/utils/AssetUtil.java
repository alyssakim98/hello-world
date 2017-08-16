package utils;

import java.util.List;
import java.util.function.Predicate;

import data.Asset;
import data.Asset.AssetType;

public class AssetUtil {

	public static int getTotalAssetValue(final List<Asset> assets){
		return assets.stream().mapToInt(Asset::getAssetValue).sum();
	}
	
	public static int getTotalBondValue(final List<Asset> assets){
		return assets.stream().mapToInt(
				asset -> asset.getAssetType() == AssetType.BOND ? asset.getAssetValue(): 0 
				).sum();
	}
	
	public static int getTotalStockValue(final List<Asset> assets){
		return assets.stream().mapToInt(
				asset -> asset.getAssetType() == AssetType.STOCK ? asset.getAssetValue(): 0 
				).sum();
	}
	
	public static int sumValues(final List<Asset> assets, final Predicate<Asset> assetSelector){
		return assets.stream().filter(assetSelector).mapToInt(Asset::getAssetValue).sum();
	}
}
