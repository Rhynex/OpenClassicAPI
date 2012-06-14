package ch.spacebase.openclassic.api;

public interface ProgressBar {

	/**
	 * Gets the text the progress bar is showing.
	 * @return The progress bar's text.
	 */
	public String getText();
	
	/**
	 * Sets the text of the progress bar for the next setProgress call.
	 * @param Text to set.
	 */
	public void setText(String text);
	
	/**
	 * Gets the title the progress bar is showing.
	 * @return The progress bar's title.
	 */
	public String getTitle();
	
	/**
	 * Sets the title of the progress bar for the next setProgress call.
	 * @param Title to set.
	 */
	public void setTitle(String title);
	
	/**
	 * Gets the progress bar's progress.
	 * @return The progress bar's progress.
	 */
	public int getProgress();
	
	/**
	 * Sets the progress bar's progress and updates the display.
	 * @param Progress to set.
	 */
	public void setProgress(int progress);
	
}
