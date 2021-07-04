package kr.pe.norimsu.springrestdocs.controller;

import static kr.pe.norimsu.springrestdocs.model.ResponseEnvelop.ERROR;
import static kr.pe.norimsu.springrestdocs.model.ResponseEnvelop.OK;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.norimsu.springrestdocs.model.ResponseEnvelop;
import kr.pe.norimsu.springrestdocs.model.User;
import kr.pe.norimsu.springrestdocs.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEnvelop<User> create(@RequestBody User requestUser) {
        final User user = userService.create(requestUser);
        if (user != null) {
            return OK(user);
        }
        return ERROR();
    }

    @GetMapping("{id}")
    public ResponseEnvelop<User> read(@PathVariable(name = "id") Long id) {
        final User user = userService.read(id);
        if (user != null) {
            return OK(user);
        }
        return ERROR();
    }

    @PutMapping("")
    public ResponseEnvelop<User> update(@RequestBody User requestUser) {
        final User user = userService.update(requestUser);
        if (user != null) {
            return OK(user);
        }
        return ERROR();
    }

    @DeleteMapping("{id}")
    public ResponseEnvelop<User> delete(@PathVariable(name = "id") Long id) {
        final boolean isDeleted = userService.delete(id);
        if (isDeleted) {
            return OK();
        }
        return ERROR();
    }
}
