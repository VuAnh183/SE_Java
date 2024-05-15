package studentman;

/**
 * @overview Represents a document that can be converted to HTML format 
 * @author Dinh Vu Anh
 * 		https://github.com/VuAnh183/SE_Java
 */
interface Document {
	/**
	 * 
	 * @effects return a string that can be used to generate an HTML document
	 * <pre>
	 * &lt;html&gt;
     * &lt;head&gt;&lt;title&gt;  title_here  &lt;/title&gt;
     * &lt;body&gt;
     *      body_here
     * &lt;/body&gt;&lt;/html&gt;
     * </pre>
	 */
	public String toHtmlDoc();
	
}
