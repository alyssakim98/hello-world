package data;

public class Asset {

	public enum AssetType { BOND, STOCK };
	private final AssetType _assetType;
	private final int _assetValue;
	
	public Asset(final AssetType assetType, final int assetValue){
		this._assetType = assetType;
		this._assetValue = assetValue;
	}

	public AssetType getAssetType() {
		return _assetType;
	}

	public int getAssetValue() {
		return _assetValue;
	}
	
}
