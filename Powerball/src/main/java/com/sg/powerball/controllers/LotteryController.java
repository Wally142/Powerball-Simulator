package com.sg.powerball.controllers;

import com.sg.powerball.model.LottoNumber;
import com.sg.powerball.model.Purchase;
import com.sg.powerball.service.LotteryService;
import java.sql.Date;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/lottery")
    public String lottery(Model model) {

//        LottoNumber test = new LottoNumber();
//        LocalDate drawingdate = LocalDate.now();
//        LottoNumber numbers = lotteryService.getNumbers(drawingdate);
        LottoNumber numbers = lotteryService.generateNumbers();

        model.addAttribute("numbers", numbers);
//        model.addAttribute("date", drawingdate);

        return "lottery";
    }

    @GetMapping("/purchase")
    public String purchase(Model model) {
        LottoNumber test = new LottoNumber();
        model.addAttribute("randomNum", test);
        model.addAttribute("purchase", new Purchase());
        return "purchase";
    }

    @PostMapping("/purchase")
    public String buyTicket(@Valid Purchase purchase, BindingResult result, Model model, String action) {

        if (action.equals("quick")) {

            LottoNumber num = lotteryService.generateNumbers();
            model.addAttribute("randomNum", num);
            return "purchase";
        } else if (action.equals("man")) {

            if (result.hasErrors()) {
                model.addAttribute("purchase", purchase);
                return "purchase";
            } else {
                System.out.println("quickpick " + purchase.isQuickpick());
                lotteryService.saveTicket(purchase);
            }
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(Model model) {

        return "search";
    }

    @PostMapping("/search")
    public String findLottoTicket(String lastname, String state, Model model) {

        Purchase ticket = lotteryService.findTicket(lastname, state);
        model.addAttribute("result", ticket);
        System.out.println("Found Ticket: " + ticket.getLastname() + "" + ticket.getState());

        return "search";
    }

}
