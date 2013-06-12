package vmware;

/*
 * sendRedirect() sends a redirect response back to the client's browser. The browser will normally interpret this response by initiating a new request 
 * to the redirect URL given in the response.
 * forward() does not involve the client's browser. It just takes browser's current request, and hands it off to another servlet/jsp to handle.
 *  The client doesn't know that they're request is being handled by a different servlet/jsp than they originally called.
 * There are different situations where you want to use one or the other. For example, if you want to hide the fact that you're handling the browser request
 * with multiple servlets/jsp, and all of the servlets/jsp are in the same web application, use forward() or include(). 
 * If you want the browser to initiate a new request to a different servlet/jsp, or if the servlet/jsp you want to forward to is not in the same web application,
 *  use sendRedirect().
 *
 * same request object in forward while a new request object is used in sendRedirect....
 * so same request parameters can be retrieved in forward only!
 */
public class SendRiderctAndForward {

}
