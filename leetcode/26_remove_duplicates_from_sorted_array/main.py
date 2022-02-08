def remove_duplicates(nums):
    e = 1
    f = 0
    count = 1
    while e < len(nums):
        if nums[e] <= nums[f]:
            e += 1
        else:
            nums[f + 1] = nums[e]
            count += 1
            e += 1
            f += 1
    return nums
