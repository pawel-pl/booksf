package capitaliq;

/*
 * 1. Checks link's URL part. If not empty take that URL to be feteched. 
 * 2. browser checks cache; if requested object is in cache and is fresh, skip to #9 
 * 3. browser asks OS for server's IP address 
 * 4. OS makes a DNS lookup and replies the IP address to the browser 
 * 5. browser opens a TCP connection to server (this step is much more complex with HTTPS) 
 * 6. browser sends the HTTP request through TCP connection 
 * 7. browser receives HTTP response and may close the TCP connection, or reuse it for another request 
 * 8. browser checks if the response is a redirect (3xx result status codes), authorization request (401), error (4xx and 5xx), etc.; these are handled differently from normal responses (2xx) 
 * 9. if cacheable, response is stored in cache 
 * 10. browser decodes response (e.g. if it's gzipped) 
 * 11. browser determines what to do with response (e.g. is it a HTML page, is it an image, is it a sound clip?) 
 * 12. browser renders response, or offers a download dialog for unrecognized types 
 */
public class WhatHappensAfterLinkClick {

}
