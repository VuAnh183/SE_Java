package a2_BIxx_yyy.studentman;

/**
 * @overview
 *   Represents a document that can be converted to HTML format
 */
interface Document {
    /**
     * @effects
     *   return a string that can be used to generate an HTML document
     * &lt;html&gt;
     * &lt;head&gt;&lt;title&gt;  title_here  &lt;/title&gt;
     * &lt;body&gt;
     *      body_here
     * &lt;/body&gt;&lt;/html&gt;
     */
    public String toHtmlDoc();
}
