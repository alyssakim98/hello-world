package app;

import java.util.Arrays;
import java.util.List;

import data.Asset;
import data.Asset.AssetType;
import utils.AssetUtil;

public class ArchitectureTester implements Runnable {

	public static void main(String[] args){
		Thread thread = new Thread(new ArchitectureTester());
		thread.start();
	}
	
	@Override
	public void run() {
		try {
			List<Asset> assets = getAssets();
			System.out.println("Total: "+AssetUtil.getTotalAssetValue(assets));
			System.out.println("Total Bond: "+AssetUtil.getTotalBondValue(assets));
			System.out.println("Total Stock: "+AssetUtil.getTotalStockValue(assets));
			System.out.println("===== < By using Predicate > =====");	
			System.out.println("Total: "+AssetUtil.sumValues(assets, asset -> true));
			System.out.println("Total Bond: "+AssetUtil.sumValues(assets, asset -> asset.getAssetType() == AssetType.BOND));
			System.out.println("Total Stock: "+AssetUtil.sumValues(assets, asset -> asset.getAssetType() == AssetType.STOCK));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Asset> getAssets(){
		final List<Asset> assets = Arrays.asList(
				new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.BOND, 2000),
				new Asset(Asset.AssetType.STOCK, 2500),
				new Asset(Asset.AssetType.STOCK, 3000)
				);
		return assets;
	}
}
