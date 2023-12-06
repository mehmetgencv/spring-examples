package org.mehmetgenc.springdatajpapostgresql.service.impl;

import lombok.RequiredArgsConstructor;
import org.mehmetgenc.springdatajpapostgresql.dto.UserDto;
import org.mehmetgenc.springdatajpapostgresql.entity.Address;
import org.mehmetgenc.springdatajpapostgresql.entity.User;
import org.mehmetgenc.springdatajpapostgresql.repo.AddressRepository;
import org.mehmetgenc.springdatajpapostgresql.repo.UserRepository;
import org.mehmetgenc.springdatajpapostgresql.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        User userDb = userRepository.save(user);

        List<Address> addressList = new ArrayList<>();
        userDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setUser(userDb);
            addressList.add(address);
        }
        );
        addressRepository.saveAll(addressList);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(item -> {
            UserDto userDto = new UserDto();
            userDto.setId(item.getId());
            userDto.setName(item.getName());
            userDto.setSurname(item.getSurname());
            userDto.setAddresses(item.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList()));
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
