package ru.vav.repost.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.vav.repost.entity.Order;
import ru.vav.repost.service.IOrderService;

/**
 * @author vav
 *         Form order controller
 */
@Controller
public class OrderController {

    @Autowired
    private IOrderService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/order/add";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public String showAddOrderForm(Model model) {
        model.addAttribute("orderForm", new Order());
        return "order/orderform";
    }

    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public String showOrdersForm(Model model) {
        model.addAttribute("orders", service.getAllOrders());
        return "order/list";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("orderForm") @Validated Order order,
                                   BindingResult result, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "order/orderform";
        }

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", order.isNew() ? "Order added successfully!" : "Order updated successfully!");

        Order saveOrUpdate = service.saveOrUpdate(order);

        // POST/REDIRECT/GET
        return "redirect:/order/" + saveOrUpdate.getOrderId();
        // POST/FORWARD/GET
        // return "user/list";
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String showOrder(@PathVariable("id") int id, Model model) {
        Order order = service.findById(id);
        if (order == null) {
            model.addAttribute("css", "danger"); //todo rename - The model should not know what is used to view (css or somebody else)
            model.addAttribute("msg", "Order not found");
        }
        model.addAttribute("order", order);

        return "order/show";
    }
}
