package baiTapTuan5.lab2;

public class TemplatePatternDemo {
	public static void main(String[] args) {
		TitleInfo bladeRunner = new DvdTitleInfo("Blade Runner", "Harrison Ford", '1');
		TitleInfo electricSheep = new BookTitleInfo("Do Androids Dream of Electric Sheep?", "Philip");
		System.out.println("Testing bladeRunner" + bladeRunner.processTitleInfo());
		System.out.println(" ");
		System.out.println("Testing electricSheep" + electricSheep.processTitleInfo());
	}
}
